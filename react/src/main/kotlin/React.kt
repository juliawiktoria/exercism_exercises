class Reactor<T> {
    private val callbacks: MutableMap<RegisteredCallback, (T) -> Unit> = mutableMapOf()
    private var counter: Int = 0
    private val pendingNotifications: MutableList<RegisteredCallback> = mutableListOf()
    private val pendingNotificationValues: MutableMap<RegisteredCallback, T> = mutableMapOf()
    interface Subscription {
        fun cancel()
    }
    interface Source<T> {
        val value: T
        fun addCallback(callback: (T) -> Unit): Subscription
    }
    private inner class RegisteredCallback(private val target: Int) : Subscription, Comparable<RegisteredCallback> {
        override fun cancel() {
            callbacks.remove(this)
        }
        override fun compareTo(other: RegisteredCallback): Int =
            this.target.compareTo(other.target)
    }
    private fun notify(targets: List<RegisteredCallback>, value: T) {
        // If it starts as empty, we'll leave it in that state when we're done.
        val shouldProcessAll = pendingNotifications.isEmpty()
        pendingNotifications.addAll(targets.filterNot { pendingNotifications.contains(it) })
        pendingNotifications.sort()
        for (target in targets) {
            pendingNotificationValues[target] = value
        }
        while (shouldProcessAll && pendingNotifications.isNotEmpty()) {
            val target = pendingNotifications.removeAt(0)
            val value = pendingNotificationValues.remove(target)
            if (value != null) callbacks[target]?.invoke(value)
        }
    }
    private fun registerCallback(f: (T) -> Unit): RegisteredCallback =
        RegisteredCallback(counter++).also { reg -> callbacks[reg] = f }
    inner class InputCell(t: T) : Source<T> {
        private var stored: T = t
        private val callbackTargets: MutableList<RegisteredCallback> = mutableListOf()
        override var value: T
            get() = stored
            set(t) {
                val old = stored
                stored = t
                if (old != stored) notify(callbackTargets, stored)
            }
        override fun addCallback(callback: (T) -> Unit): Subscription =
            registerCallback(callback).also { callbackTargets.add(it) }
    }
    inner class ComputeCell(vararg sources: Source<T>, update: (List<T>) -> T) : Source<T> {
        private val update: () -> T = {
            update(sources.map { it.value })
        }
        override val value: T
            get() = cached
        private var cached: T
        private val callbackTargets: MutableList<RegisteredCallback> = mutableListOf()
        private fun refresh() {
            val old = cached
            cached = this.update()
            if (old != cached) notify(callbackTargets, cached)
        }
        override fun addCallback(callback: (T) -> Unit): Subscription =
            registerCallback(callback).also { callbackTargets.add(it) }
        init {
            sources.forEach { it.addCallback { this.refresh() } }
            cached = this.update()
        }
    }
}
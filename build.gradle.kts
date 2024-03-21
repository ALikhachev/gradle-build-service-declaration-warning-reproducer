group = "org.example"
version = "1.0-SNAPSHOT"

abstract class MyBuildService : BuildService<BuildServiceParameters.None>

abstract class MyTask : DefaultTask() {
    @get:Internal
    abstract val myBuildService: Property<MyBuildService>

    @TaskAction
    fun doSomething() {
        myBuildService.get()
    }
}

tasks.register<MyTask>("myTask") {
    myBuildService.set(gradle.sharedServices.registerIfAbsent("my-service", MyBuildService::class.java) {})
}
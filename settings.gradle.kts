rootProject.name = "gradle-build-service-declaration-warning-reproducer"

abstract class MySettingsBuildService : BuildService<BuildServiceParameters.None>

val registerSettingsServiceBeforeFeaturePreview = providers.gradleProperty("registerSettingsServiceBeforeFeaturePreview").orNull.toBoolean()
val registerSettingsServiceAfterFeaturePreview = providers.gradleProperty("registerSettingsServiceAfterFeaturePreview").orNull.toBoolean()

if (registerSettingsServiceBeforeFeaturePreview) {
    gradle.sharedServices.registerIfAbsent(
        "my-settings-service",
        MySettingsBuildService::class.java
    ) {}
}

enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

if (registerSettingsServiceAfterFeaturePreview) {
    gradle.sharedServices.registerIfAbsent(
        "my-settings-service",
        MySettingsBuildService::class.java
    ) {}
}
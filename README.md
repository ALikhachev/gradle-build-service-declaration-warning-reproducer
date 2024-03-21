# Lost undeclared build service usage warning reproducer

## Scenarios:
### No settings build service
`./gradlew :myTask`

The build fails as expected with the warning message:
```
Build service 'my-service' is being used by task ':myTask' without the corresponding declaration via 'Task#usesService'
```

### Settings build service applied after enabling feature preview "STABLE_CONFIGURATION_CACHE"
`./gradlew :myTask -PregisterSettingsServiceAfterFeaturePreview=true`

The build fails as expected with the warning message:
```
Build service 'my-service' is being used by task ':myTask' without the corresponding declaration via 'Task#usesService'
```

### Settings build service applied before enabling feature preview "STABLE_CONFIGURATION_CACHE"
`./gradlew :myTask -PregisterSettingsServiceBeforeFeaturePreview=true`

The build passes??
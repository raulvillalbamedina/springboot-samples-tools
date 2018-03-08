# SPRING-ASYNC

This module is used to configure the spring ThreadPoolTaskExecutor. This is the configuration to use @Async with spring. 

More info at: 

	<https://spring.io/guides/gs/async-method/>

To configure this we use the application.properties. To see and example view de file application-dev.properties in src/test/resources

The actual properties are:

	async.executor.corePoolSize=
	async.executor.maxPoolSize=
	async.executor.queueCapacity=
	async.executor.threadNamePrefix= 
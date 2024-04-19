# What is this jar file?

This jar file is a client generator for swagger source files. It is used indirectly via gradle tasks to generate Rally rest api clients.

# How to update this jar file

This jar file is maintained by Rally Framework team.

# How to update this file really?

1. Extract the exiting jar file
`jar xvf 'PATH_TO_JAR_FILE_HERE'`
2. Make any required modifications to mustache files.
- For example if you need to update gradle version, than you should change `<BASE_PATH>\java\libraries\retrofit2\gradle-wrapper.properties.mustache`
2. Re-package the jar file
`jar cfe a.jar io.swagger.codegen.SwaggerCodegen -C 'PATH_TO_EXTRACTED_FILES_BASE_PATH_HERE' .`
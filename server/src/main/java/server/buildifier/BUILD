load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "buildifier",
    srcs = [
        "Buildifier.java",
        "BuildifierCommand.java",
        "BuildifierException.java",
        "BuildifierFileType.java",
        "BuildifierNotFoundException.java",
        "FormatInput.java",
        "FormatOutput.java",
        "LintFile.java",
        "LintInput.java",
        "LintOutput.java",
        "LintWarning.java",
        "LintWarningPosition.java",
    ],
    deps = [
        "//server/src/main/java/server/utils",
        "//server/src/main/java/server/workspace",
        "//server/src/main/java/server/dispatcher",
        "//third_party/java:gson",
        "//third_party/java:guava",
        "//third_party/java:log4j",
    ],
)

load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "commands",
    srcs = glob(["**/*.java"]),
    deps = [
        "//server/src/main/java/server/dispatcher",
        "//server/src/main/java/server/bazel/cli",
        "//server/src/main/java/server/utils",
        "//server/src/main/java/server/workspace",
        "//third_party/java:gson",
        "//third_party/java:guava",
        "//third_party/java:log4j",
        "//third_party/java:lsp4j",
    ],
)

load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "server",
    srcs = [
        "BazelLanguageServer.java",
        "BazelServices.java",
    ],
    deps = [
        "//server/src/main/java/server/buildifier",
        "//server/src/main/java/server/codelens",
        "//server/src/main/java/server/commands",
        "//server/src/main/java/server/completion",
        "//server/src/main/java/server/diagnostics",
        "//server/src/main/java/server/doclink",
        "//server/src/main/java/server/formatting",
        "//server/src/main/java/server/utils",
        "//server/src/main/java/server/workspace",
        "//server/src/main/java/server/bazel/cli",
        "//third_party/java:gson",
        "//third_party/java:guava",
        "//third_party/java:log4j",
        "//third_party/java:lsp4j",
    ],
)

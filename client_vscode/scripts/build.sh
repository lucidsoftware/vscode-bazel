#!/usr/bin/env bash

# Copyright 2018 The Bazel Authors. All rights reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eu

cd "$(dirname "$0")/../"

readonly TSC=./node_modules/.bin/tsc
readonly PBJS=./node_modules/protobufjs/bin/pbjs
readonly PBTS=./node_modules/protobufjs/bin/pbts

# Only regenerate the .js and .t.ds file if the protos have changed (i.e.,
# it's a fresh checkout or update_protos.sh has been executed again and
# deleted the old generated files). This shaves several seconds off the
# extension's build time.
echo "Generating protobuf files..."
if [[ ! -f src/legacy/protos/protos.js ]]; then
    sed -e "s#^#src/legacy/protos/#" src/legacy/protos/protos_list.txt |
        xargs $PBJS -t static-module -o src/legacy/protos/protos.js
fi
if [[ ! -f src/legacy/protos/protos.d.ts ]]; then
    $PBTS -o src/legacy/protos/protos.d.ts src/legacy/protos/protos.js
fi

# Compile the rest of the project.
echo "Compiling the rest of the project..."
$TSC "$@" -p ./

echo "Compiled successfully."

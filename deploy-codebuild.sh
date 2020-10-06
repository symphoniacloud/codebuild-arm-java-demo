#!/bin/sh

set -euo pipefail

aws cloudformation deploy \
        --region us-east-1 \
        --stack-name codebuild-arm-java-demo \
        --template-file codebuild.yaml \
        --capabilities CAPABILITY_IAM \
        --no-fail-on-empty-changeset

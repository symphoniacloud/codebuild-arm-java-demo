# codebuild-arm-java-demo

This is a demonstration / sample for running Java on AWS CodeBuild with an ARM CPU.
Why?
Because cloud workloads are starting to shift to ARM, and this shows doing so with Java is another step along in its evolution!

## The results

CodeBuild runs a small Java class that prints all of the JVM's System properties.
At time of writing this includes the following:

```
java.runtime.version=11.0.8+10-LTS
java.vendor.version=Corretto-11.0.8.10.1
java.version.date=2020-07-14
java.vm.version=11.0.8+10-LTS
os.arch=aarch64
os.name=Linux
os.version=4.14.186-146.268.amzn2.aarch64
sun.arch.data.model=64
sun.boot.library.path=/usr/lib/jvm/java-11-amazon-corretto.aarch64/lib
```

These results are **running in us-east-1** on October 6 2020.

## How is this configured?

Everything's in the [CloudFormation template](codebuild.yaml), but here's the key section in the CodeBuild project configuration:

```yaml
Environment:
    ComputeType: BUILD_GENERAL1_LARGE
    Image: aws/codebuild/amazonlinux2-aarch64-standard:2.0
    Type: ARM_CONTAINER
```

At time of writing `BUILD_GENERAL1_LARGE` is the only ARM ComputeType available.

## How to run yourself

1. Fork or copy this repo if you want to make any changes
1. Update the [codebuild.yaml](codebuild.yaml), e.g. for different repo location, and/or if you need to include Github credentials inline (or need to change repo type entirely).
As it stands, the CodeBuild configuration assumes an `AWS::CodeBuild::SourceCredential` is deployed elsewhere in this account + region
(see [here](https://github.com/symphoniacloud/coffee-store/blob/3a33f9a330d2ff2db73389b18472a7e758d1114b/account-wide-resources/template.yaml) for an example doing this.) 
1. Run [deploy-codebuild.sh](deploy-codebuild.sh) to deploy the CodeBuild project to us-east-1 (update region if you'd like, but make sure ARM + CodeBuild is available in the region you pick).
This requires you have AWS CLI installed, and an AWS profile configured.  

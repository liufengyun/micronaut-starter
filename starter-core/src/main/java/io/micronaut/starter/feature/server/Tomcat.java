/*
 * Copyright 2017-2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.starter.feature.server;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.starter.application.generator.GeneratorContext;
import io.micronaut.starter.build.dependencies.Dependency;
import io.micronaut.starter.options.BuildTool;

import jakarta.inject.Singleton;

@Singleton
public class Tomcat extends AbstractMicronautServerFeature {

    @Override
    public String getName() {
        return "tomcat-server";
    }

    @Override
    public String getTitle() {
        return "Tomcat Server";
    }

    @Override
    public String getDescription() {
        return "Adds support for a Tomcat server";
    }

    @Override
    public String getMicronautDocumentation() {
        return "https://micronaut-projects.github.io/micronaut-servlet/1.0.x/guide/index.html#tomcat";
    }

    @Override
    public void doApply(GeneratorContext generatorContext) {
        if (generatorContext.getBuildTool() == BuildTool.MAVEN) {
            generatorContext.addDependency(Dependency.builder()
                    .groupId("io.micronaut.servlet")
                    .artifactId("micronaut-http-server-tomcat")
                    .compile());
        }
    }

    @Override
    @NonNull
    public String resolveMicronautRuntime(@NonNull GeneratorContext generatorContext) {
        return "tomcat";
    }
}

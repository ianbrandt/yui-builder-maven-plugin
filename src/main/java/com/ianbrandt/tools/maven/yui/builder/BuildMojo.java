package com.ianbrandt.tools.maven.yui.builder;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.sonatype.plexus.build.incremental.BuildContext;

/**
 * Goal which executes a YUI Build Tool component build.
 */
@Mojo(name = "build", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class BuildMojo extends AbstractMojo {

	@Component
	private BuildContext buildContext;

	/**
	 * Source directory containing YUI modules (i.e. <code>${srcdir}/src</code>).
	 */
	@Parameter(defaultValue="${basedir}/src/main/yui", required=true)
	private File sourceDirectory;

	/**
	 * Build directory where YUI modules are deployed to by the component build
	 * (i.e. the <code>${global.build.base}</code>).
	 */
	@Parameter(defaultValue="${project.build.directory}/generated-sources/yui", required=true)
	private File buildDirectory;

	public void execute() throws MojoExecutionException {

		if (!buildDirectory.exists()) {
			buildDirectory.mkdirs();
		}
	}
}

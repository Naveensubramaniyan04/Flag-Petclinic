/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import io.rollout.rox.server.Rox;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.concurrent.ExecutionException;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(PetClinicApplication.class, args);

		// Initialize Flags container class
		Flags flags = new Flags();
		// Register the flags container under a namespace
		Rox.register("default", flags);
		// Setup connection with the feature management environment key
		Rox.setup("fc1c3d1e-146a-46c3-5c2f-ce8a6440dc1a").get();
		// Prints the value of the boolean enableTutorial flag
		System.out.printf("enableTutorial value is %s", flags.enableTutorial.isEnabled() ? "true" : "false");
	}
}



/*
 * Copyright (C) 2018-2020 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.core;

import java.util.stream.Collectors;

/**
 * @since 0.3.0
 */
public class ConstraintViolationsException extends RuntimeException {
	private final ConstraintViolations violations;

	public ConstraintViolationsException(String message,
			ConstraintViolations violations) {
		super(message);
		this.violations = violations;
	}

	public ConstraintViolationsException(ConstraintViolations violations) {
		this("Constraint violations found!" + System.lineSeparator()
				+ violations.violations().stream().map(ConstraintViolation::message)
						.map(s -> "* " + s)
						.collect(Collectors.joining(System.lineSeparator())),
				violations);
	}

	public ConstraintViolations violations() {
		return violations;
	}
}

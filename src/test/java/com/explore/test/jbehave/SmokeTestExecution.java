package com.explore.test.jbehave;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;




public class SmokeTestExecution extends JUnitStories {
	

		public SmokeTestExecution(){
			super();
			this.configuredEmbedder().candidateSteps().add( new SmokeTestSteps());
		}
		@Override
		protected List<String> storyPaths() {
			return Arrays.asList("com/explore/test/jbehave/SmokeTest.story");
		}

}


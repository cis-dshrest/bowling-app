package com.test.jbehave;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.CandidateSteps;

public class SmokeTestExecution extends JUnitStories {
	

		public SmokeTestExecution(){
			super();
			this.configuredEmbedder().candidateSteps().add( new SmokeTestSteps());
		}
		@Override
		protected List<String> storyPaths() {
			// TODO Auto-generated method stub
			return Arrays.asList("lets/explore/spring/SmokeTest.story");
		}

}

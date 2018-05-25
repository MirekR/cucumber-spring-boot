package cz.mirek.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@CucumberStepsDefinition
public class GoogleSearch {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.google.base}")
    private String baseUrl;

    private String data;

    @When("^I hit search query \"([^\"]*)\"$")
    public void i_hit_search_query(String query) {
        String url = baseUrl + query;

        data = restTemplate.getForObject(url, String.class);
    }

    @Then("^I want to get result$")
    public void i_want_to_get_result() {
        assertThat(data, is(notNullValue()));
    }

}

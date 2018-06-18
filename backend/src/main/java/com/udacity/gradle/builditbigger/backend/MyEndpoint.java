package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.JavaJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com"
        )
)
public class MyEndpoint {

    /**
     * /**
     * A simple endpoint method that pull a joke from JavaJokes
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        JavaJokes javaJokes = new JavaJokes();
        String joke = javaJokes.getJoke();

        response.setData(joke);

        return response;
    }

}

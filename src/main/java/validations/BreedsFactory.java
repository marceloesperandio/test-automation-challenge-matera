package validations;

import model.BreedModel;
import model.LinkModel;
import model.BreedResponseModel;

import java.util.Arrays;
import java.util.Collections;

public class BreedsFactory {

    public static BreedResponseModel createBreedResponse() {
        BreedModel breed = BreedModel.builder()
                .breed("Abyssinian")
                .country("Ethiopia")
                .origin("Natural/Standard")
                .coat("Short")
                .pattern("Ticked")
                .build();

        LinkModel previous = LinkModel.builder()
                .url(null)
                .label("Previous")
                .active(false)
                .build();

        LinkModel page1 = LinkModel.builder()
                .url("https://catfact.ninja/breeds?page=1")
                .label("1")
                .active(true)
                .build();

        LinkModel page2 = LinkModel.builder()
                .url("https://catfact.ninja/breeds?page=2")
                .label("2")
                .active(false)
                .build();

        LinkModel next = LinkModel.builder()
                .url("https://catfact.ninja/breeds?page=2")
                .label("Next")
                .active(false)
                .build();

        return BreedResponseModel.builder()
                .current_page(1)
                .data(Collections.singletonList(breed))
                .first_page_url("https://catfact.ninja/breeds?page=1")
                .from(1)
                .last_page(98)
                .last_page_url("https://catfact.ninja/breeds?page=98")
                .links(Arrays.asList(previous, page1, page2, next))
                .next_page_url("https://catfact.ninja/breeds?page=2")
                .path("https://catfact.ninja/breeds")
                .per_page(1)
                .prev_page_url(null)
                .to(1)
                .total(98)
                .build();
    }
}
package study.servletfilter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sample")
@RestController
public class SampleController {

    @GetMapping
    public ResponseEntity<Response> sample(@RequestParam String status) {
        return ResponseEntity.ok(new Response(status + " ok"));
    }

    private static class Response {
        private final String result;

        public Response(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }
    }

}

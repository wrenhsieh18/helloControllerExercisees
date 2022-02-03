package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(path = "byLang", method = {RequestMethod.GET, RequestMethod.POST})
    public static String helloWithPathParamByLang(@RequestParam String name, @RequestParam String lang) {
        if (lang.equals("en")) {
            return String.format("Hello, %s!", name);
        } else if (lang.equals("fr")) {
            return String.format("Bonjour, %s!", name);
        } else if (lang.equals("cn")) {
            return "<html>" +
                    "<body style = 'color:green'>" +
                    "哈囉，" + name + " !" +
                    "</body>" +
                    "<html>";
            //return String.format("哈囉，%s！", name);
        } else if (lang.equals("sp")) {
            return String.format("¡Hola, %s!", name);
        } else if (lang.equals("jp")) {
            return String.format("こんにちは，%s！", name);
        } else {
            return "Hello, " + name + "!";
        }

    }



    @GetMapping("form/lang")
    public String helloFormByLang() {
        return "<html> " +
                "<body>" +
                "<form action = '/hello/byLang' method = 'post'>" +
                    "<input type = 'text' name = 'name'>" +
                    "<select id = 'lang' name = 'lang'>" +
                        "<option value = 'en'>English</option>" +
                        "<option value = 'fr'>Français</option>" +
                        "<option value = 'cn'>中文</option>" +
                        "<option value = 'sp'>Español</option>" +
                        "<option value = 'jp'>日本語</option>" +
                    "</select>" +
                    "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}

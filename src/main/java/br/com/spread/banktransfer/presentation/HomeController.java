package br.com.spread.banktransfer.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{

   @RequestMapping("/")
   public String index()
   {
      return "/home/menu";
   }
}

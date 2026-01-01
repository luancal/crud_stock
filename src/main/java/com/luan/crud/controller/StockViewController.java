package com.luan.crud.controller;

import com.luan.crud.entities.Stock;
import com.luan.crud.services.StockService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/stocks")
public class StockViewController {

    private final StockService stockService;

    public StockViewController(StockService stockService) {
        this.stockService = stockService;
    }

    private boolean notLogged(HttpSession session) {
        return session.getAttribute("logged") == null;
    }

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (notLogged(session)) return "redirect:/login";

        model.addAttribute("stocks", stockService.stockTotal());
        return "stock-list";
    }

    @GetMapping("/new")
    public String form(Model model, HttpSession session) {
        if (notLogged(session)) return "redirect:/login";

        model.addAttribute("stock", new Stock());
        return "stock-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        if (notLogged(session)) return "redirect:/login";

        model.addAttribute("stock", stockService.getId(id));
        return "stock-form";
    }

    @PostMapping
    public String save(Stock stock, HttpSession session) {
        if (notLogged(session)) return "redirect:/login";

        stockService.sumItem(stock);
        return "redirect:/view/stocks";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        if (notLogged(session)) return "redirect:/login";

        stockService.deleteItem(id);
        return "redirect:/view/stocks";
    }
}
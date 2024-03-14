package ru.selpo.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.selpo.manager.controller.payload.NewProductPayload;
import ru.selpo.manager.service.ProductService;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public String getProductsList(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String create(NewProductPayload payload) {
        this.productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list";
    }

}

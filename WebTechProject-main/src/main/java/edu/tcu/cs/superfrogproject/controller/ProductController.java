//package edu.tcu.cs.hogwartsonlinestore.controller;
//
//import edu.tcu.cs.hogwartsonlinestore.dao.ProductRepository;
//import edu.tcu.cs.hogwartsonlinestore.domain.Product;
//import edu.tcu.cs.hogwartsonlinestore.service.ProductService;
//import edu.tcu.cs.hogwartsonlinestore.utils.FileUploadUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@Controller
//@RequestMapping("/product")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @Value("${fileUploadURL}")
//    private String uploadPath;
//
//    @GetMapping("/list")
//    public String findAll(Model model){
//        List<Product> products = productService.findAll();
//        model.addAttribute("prods", products);
//        return "product/list";
//    }
//
//    @PostMapping()
//    public String save(Product newProduct, Model model, @RequestParam("image") MultipartFile multipartFile) throws IOException {
//        // handle uploaded images
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        // 1-m00-21-f0-rb8lb2blkveajfuzaajxhs8kwbw138_840_840.png
//        if(StringUtils.hasLength(fileName)){
//            int index = fileName.lastIndexOf(".");
//            fileName = newProduct.getName().replace("\\s", "") + fileName.substring(index);
//            // OnePlug9.png
//            newProduct.setImageURL("/images/products/" + fileName);
//            FileUploadUtil.saveFile(uploadPath, fileName, multipartFile);
//        }
//        // save the product in DB
//        Product savedProduct = productService.save(newProduct);
//        return "redirect:product/show/" + savedProduct.getId();
//    }
//
//    @GetMapping("/new")
//    public String newProduct(Model model) {
//        model.addAttribute("product", new Product());
//        return "product/productform";
//    }
//
//    @GetMapping("/show/{id}")
//    public String getProduct(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.findById(id));
//        return "product/show";
//    }
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "product/productform";
//    }
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id) {
//        productService.delete(id);
//        return "redirect:/product/list";
//    }
//
//    @GetMapping("/comments")
//    public String getComments(@RequestParam Integer prodId, Model model){
//        Product product = productService.findById(prodId);
//        model.addAttribute("product", product);
//        return "product/comments";
//    }
//}

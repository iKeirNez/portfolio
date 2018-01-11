package com.keirnellyer.portfolio.controller.api;

import com.keirnellyer.portfolio.entity.Site;
import com.keirnellyer.portfolio.repository.ISiteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sites")
public class SiteController {
    private ISiteRepository siteRepository;

    public SiteController(ISiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Site getSite(@PathVariable  int id) {
        return siteRepository.findOne(id);
    }
}

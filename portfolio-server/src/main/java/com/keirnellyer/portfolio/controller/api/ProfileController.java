package com.keirnellyer.portfolio.controller.api;

import com.keirnellyer.portfolio.entity.Profile;
import com.keirnellyer.portfolio.repository.IProfileRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private IProfileRepository profileRepository;

    public ProfileController(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Profile getProfile(@PathVariable int id) {
        return profileRepository.findOne(id);
    }
}

package org.microservice.services;
import org.microservice.dto.OnboardingDto;
import org.microservice.models.CharityModel;
import org.microservice.repository.Charity.CharityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharityService {

    private final CharityRepository charityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CharityService(CharityRepository charityRepository, ModelMapper modelMapper) {
        this.charityRepository = charityRepository;
        this.modelMapper = modelMapper;
    }

    public CharityModel saveCharity(OnboardingDto onboardingDto){

        CharityModel charityModel = modelMapper.map(onboardingDto,CharityModel.class);

        return charityRepository.save(charityModel);

    }
}

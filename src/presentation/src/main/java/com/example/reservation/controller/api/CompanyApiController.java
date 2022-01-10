package com.example.reservation.controller.api;

import com.example.reservation.domain.dto.ItemDto;
import com.example.reservation.domain.dto.RequestCompanyDto;
import com.example.reservation.domain.dto.ResponseCompanyDto;
import com.example.reservation.domain.dto.ResponseDto;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.service.Impl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@RestController
public class CompanyApiController {

    private final CompanyServiceImpl companyService;

    /**
     * 업체 생성
     * @param requestCompanyDto
     * @return
     */
    @PostMapping("/new")
    public ResponseDto<ResponseCompanyDto> saveCompany(@RequestBody RequestCompanyDto requestCompanyDto) {
        Company company = requestCompanyDto.toEntity();
        log.info("DTO 출력 : {}", requestCompanyDto);
        log.info("업체 DTO 변환이름 : {}", company.getCompanyName());

//        companyService.join(company);


        Company findCompany = (Company) companyService.getMember(company.getId());
        return new ResponseDto<>(findCompany.toResponseDto());
    }

    /**
     * 특정 업체 조회
     * @param companyId
     * @return
     */
    @GetMapping("/{companyId}")
    public ResponseDto<ResponseCompanyDto> getCompany(@PathVariable Long companyId) {
        Company findCompany = (Company) companyService.getMember(companyId);
        log.info("{} 업체 조회", findCompany.getCompanyName());

        return new ResponseDto<>(findCompany.toResponseDto());
    }

    /**
     * 모든 업체 조회
     * @return
     */
    @GetMapping
    public ResponseDto<List<ResponseCompanyDto>> getCompanies() {
        List<Member> members = companyService.getMembers();

        List<ResponseCompanyDto> collect = members.stream()
                .map(m -> (Company) m)
                .map(Company::toResponseDto)
                .collect(Collectors.toList());
        return new ResponseDto<>(collect.size(), collect);
    }

    /**
     * 특정 업체 수정
     * @param companyId
     * @param requestCompanyDto
     * @return
     */
    @PutMapping("/{companyId}")
    public ResponseDto<ResponseCompanyDto> updateCompany(@PathVariable Long companyId,
                                                         @RequestBody @Valid RequestCompanyDto requestCompanyDto) {
        companyService.update(companyId, requestCompanyDto.toEntity());

        Company company = (Company) companyService.getMember(companyId);
        return new ResponseDto<>(company.toResponseDto());
    }

    /**
     * 특정 업체 삭제
     * @param companyId
     * @return
     */
    @DeleteMapping("/{companyId}")
    public String removeCompany(@PathVariable Long companyId) {
        companyService.remove(companyId);

        return "삭제 되었습니다.";
    }

    /**
     * 특정 업체의 아이템 추가
     * @param companyId
     * @param itemDto
     * @return
     */
    @PostMapping("/{companyId}")
    public ResponseDto<ResponseCompanyDto> createItem(@PathVariable Long companyId,
                                                      @RequestBody @Valid ItemDto itemDto) {
        companyService.createItem(companyId, itemDto.toEntity());
        Company company = (Company) companyService.getMember(companyId);

        return new ResponseDto<>(company.toResponseDto());
    }

    /**
     * 특정 업체의 아이템 삭제
     * @param companyId
     * @param itemId
     * @return
     */
    @DeleteMapping("/{companyId}/{itemId}")
    public ResponseDto<ResponseCompanyDto> createItem(@PathVariable Long companyId,
                                                      @PathVariable Long itemId) {
        companyService.removeItem(companyId, itemId);
        Company company = (Company) companyService.getMember(companyId);

        return new ResponseDto<>(company.toResponseDto());
    }


}

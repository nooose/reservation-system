package com.example.reservation.controller.api;

import com.example.reservation.domain.dto.RequestAdminDto;
import com.example.reservation.domain.dto.ResponseAdminDto;
import com.example.reservation.domain.entity.Admin;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.service.Impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminApiController {

    private final AdminServiceImpl adminService;

    /**
     * Admin 생성
     * @param requestAdminDto
     * @return
     */
    @PostMapping
    public ResponseAdminDto saveAdmin(@RequestBody RequestAdminDto requestAdminDto){
        Admin admin = requestAdminDto.toEntity();
        log.info("Admin DTO 출력 : {}", requestAdminDto);
        log.info("admin Entity 변환 출력: {}", admin.getName());
//        adminService.join(admin);

        Admin findAdmin = (Admin) adminService.getMember(admin.getId());
        return findAdmin.toResponseDto();
    }

    /**
     * 특정 Admin 조회
     * @param adminId
     * @return
     */
    @GetMapping("/{adminId}")
    public ResponseAdminDto getAdmin(@PathVariable Long adminId){
        Admin findAdmin = (Admin) adminService.getMember(adminId);
        return findAdmin.toResponseDto();
    }

    /**
     * 모든 Admin 조회
     * @return
     */
    @GetMapping("/admins")
    public List<ResponseAdminDto> getAdmins(){
        List<Member> members = adminService.getMembers();

        return members.stream()
                .map(m -> (Admin) m)
                .map(Admin::toResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * 특정 admin 수정
     * @param adminId
     * @param requestAdminDto
     * @return
     */
    @PutMapping("/{adminId}")
    public ResponseAdminDto updateAdmin(@PathVariable Long adminId, @RequestBody RequestAdminDto requestAdminDto){
        adminService.update(adminId, requestAdminDto.toEntity());

        Admin updatAdmin = (Admin) adminService.getMember(adminId);
        return updatAdmin.toResponseDto();
    }


    /**
     * 특정 Admin 삭제
     * @param adminId
     * @return
     */
    @DeleteMapping("/{adminId}")
    public String removeAdmin(@PathVariable Long adminId){
        adminService.remove(adminId);
        return "삭제되었습니다.";
    }




}

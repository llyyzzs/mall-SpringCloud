package com.atguigu.ssyx.sys.api;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.sys.Region;
import com.atguigu.ssyx.model.sys.RegionWare;
import com.atguigu.ssyx.sys.service.RegionService;
import com.atguigu.ssyx.sys.service.RegionWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sys/region")
public class AddressApiController {

    @Autowired
    private RegionWareService regionService;

    //根据userId查询提货点和团长信息
    @GetMapping("/findAllList")
    public Result getUserAddressByUserId(String showLoading) {
        List<RegionWare> allList = regionService.findAllList(showLoading);
        return Result.ok(allList);
    }
}

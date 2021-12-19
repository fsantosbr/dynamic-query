package com.fsantosinfo.controller;

import java.util.List;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.model.dto.QueryResponseDto;
import com.fsantosinfo.service.impl.QueryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/searches")
public class QueryController {
    
    @Autowired
    private QueryServiceImpl queryService;

    @PostMapping()    
    public ResponseEntity<List<QueryResponseDto>> searchAllByQuery(@RequestBody QueryRequestDto requestBody) {
        return ResponseEntity.ok().body(this.queryService.searchAllByQuery(requestBody));
    }
}

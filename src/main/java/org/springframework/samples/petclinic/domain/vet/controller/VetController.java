package org.springframework.samples.petclinic.domain.vet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.domain.vet.controller.dto.VetRequestDto;
import org.springframework.samples.petclinic.domain.vet.service.VetService;
import org.springframework.samples.petclinic.domain.vet.controller.dto.VetResponseDto;
import org.springframework.samples.petclinic.domain.vet.model.Vet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vets")
class VetController {

	private final VetService vetService;

	// 수의사 등록
	@PostMapping
	public ResponseEntity<VetResponseDto> create(@RequestBody VetRequestDto vetRequestDto) {
		var response = vetService.register(vetRequestDto);
		return ResponseEntity.ok(response);
	}

	// 전체 수의사 조회
	@GetMapping
	public ResponseEntity<List<VetResponseDto>> getAll() {
		var response = vetService.findAll();
		return ResponseEntity.ok(response);
	}

	// 특정 수의사 조회
	@GetMapping("/{vet-id}")
	public ResponseEntity<VetResponseDto> getVet(@PathVariable("vet-id") int vetId) {
		var response = vetService.findById(vetId);
		return ResponseEntity.ok(response);
	}

	// 수의사 수정
	@PutMapping("/{vet-id}")
	public ResponseEntity<VetResponseDto> update(
			@PathVariable("vet-id") int vetId, @RequestBody VetRequestDto vetRequestDto){
		var response = vetService.update(vetId, vetRequestDto);
		return ResponseEntity.ok(response);
	}

	// 수의사 삭제
	@DeleteMapping("/{vet-id}")
	public void delete(@PathVariable("vet-id") int vetId) {
		vetService.delete(vetId);
	}
}

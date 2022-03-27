package com.javachinna.controller;

import com.javachinna.model.Training;
import com.javachinna.repo.TrainingRepository;
import com.javachinna.service.ITrainingService;
import com.javachinna.service.TrainingServiceImpl;
import com.javachinna.service.exportExcel;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {
	@Autowired
	ITrainingService traingservice;
	@Autowired
	exportExcel exportExcelservice;
	@Autowired
	TrainingRepository trainingrepository;
	@Autowired
	TrainingServiceImpl trainingService;
	
	// http://localhost:8080/SpringMVC/training/retrieve-all-training
	@GetMapping("/retrieve-all-training")
	@ResponseBody
	public List<Training> getTrainings() {
		List<Training> listTrainings = traingservice.retrieveAllTrainings();
		return listTrainings;
	}
	
	// http://localhost:8080/SpringMVC/training/add-training
	@PostMapping("/add-training")
    @ResponseBody
	public ResponseEntity<byte[]> addTraining(@RequestBody Training t) throws Exception{

		traingservice.addTraining(t);
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(String.valueOf(t.getCertificat()), 500, 500));
	}
	
	// http://localhost:8080/SpringMVC/training/remove-training/{id}
	@DeleteMapping("/remove-training/{id}")
    @ResponseBody
    public void deletetraining(@PathVariable("id") Integer IdTraining){
		traingservice.deleteTraining(IdTraining);
	}
	
	// http://localhost:8080/SpringMVC/training/modify-training
	@PutMapping("/modify-training")
    @ResponseBody
    public Training modifiertraining(@RequestBody Training t){
		return traingservice.updateTrainning(t);
	}
	
	// http://localhost:8080/SpringMVC/training/retrieve-training/{id}
	@GetMapping("/retrieve-training/{id}")
	@ResponseBody
	public Training getTraining(@PathVariable("id") Integer IdTraining){
		return traingservice.retrieveTraining(IdTraining);
		
	}

	// http://localhost:8080/SpringMVC/training/affecterApprenantFormation/{idA}/{idF}
	@PostMapping("/affecterApprenantFormation/{idA}/{idF}")
	@ResponseBody
	public void affecterApprenantFormation(@PathVariable(name = "idA") Integer idUser,@PathVariable(name = "idF") Integer IdTraining){

		traingservice.affecterApprenantFormation(idUser,IdTraining);
	}

	// http://localhost:8080/SpringMVC/training/getRevenueByFormation/{idF}
	@GetMapping("/getRevenueByFormation/{idF}")
	@ResponseBody
	public Integer getRevenueByFormation(@PathVariable(name = "idF") Integer idTraining)
	{
		return traingservice.getRevenueByFormation(idTraining);
	}

	// http://localhost:8080/SpringMVC/training/download/trainings.xlsx
	@GetMapping("/download/trainings.xlsx")
	@ResponseBody
	public void downloadCsv(HttpServletResponse response) throws IOException {
		List<Training> trainingList =(List<Training>) traingservice.retrieveAllTrainings();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=trainings.xlsx");
		ByteArrayInputStream stream = exportExcelservice.traininglist(trainingList);
		IOUtils.copy(stream, response.getOutputStream());
	}
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	// http://localhost:8080/SpringMVC/training/genrateQRCode/{width}/{height}/{id}
	@GetMapping(value = "/genrateQRCode/{width}/{height}/{id}")
	@ResponseBody
	public void download(

			@PathVariable("width") Integer width,
			@PathVariable("height") Integer height,
			@PathVariable("id") Integer idTraining)
			throws Exception {

		Training training=trainingrepository.findById(idTraining).orElse(null);
		String path= training.getTrainingName();

		QRCodeGenerator.generateQRCodeImage(path, width, height, QR_CODE_IMAGE_PATH);

	}

}

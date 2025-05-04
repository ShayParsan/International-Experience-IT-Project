package be.ucll.group5.backend.InputVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@RestController
@RequestMapping("/inputVariables")
public class InputVariableController {

    @Autowired
    private InputVariableService inputVariableService;

    @GetMapping
    @Operation(summary = "Get all input variables")
    public List<InputVariable> getAllInputVariables() {
        return inputVariableService.findAll();
    }

    @GetMapping("/last/{x}")
    @Operation(summary = "Get the last x input variables")
    public List<InputVariable> getLastXInputVariables(
            @Parameter(description = "Number of input variables to be obtained") @PathVariable int x) {
        return inputVariableService.findLastX(x);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an input variable by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the input variable", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = InputVariable.class)) }),
            @ApiResponse(responseCode = "404", description = "Input variable not found", content = @Content)
    })
    public ResponseEntity<InputVariable> getInputVariableById(
            @Parameter(description = "ID of the input variable to be obtained") @PathVariable Long id) {
        return inputVariableService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create an input variable")
    public InputVariable createInputVariable(@RequestBody InputVariable inputVariable) {
        return inputVariableService.save(inputVariable);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an input variable")
    public ResponseEntity<Void> deleteInputVariable(
            @Parameter(description = "ID of the input variable to be deleted") @PathVariable Long id) {
        inputVariableService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tds")
    @Operation(summary = "Get all TDS (ppm) values")
    public List<Float> getAllTdsValues() {
        return inputVariableService.findAll().stream()
                .map(InputVariable::getTds)
                .toList();
    }

    @GetMapping("/growth")
    @Operation(summary = "Get all Water Hyacinth Growth (kg/m²) values")
    public List<Float> getAllGrowthValues() {
        return inputVariableService.findAll().stream()
                .map(InputVariable::getWaterHyacinthGrowth)
                .toList();
    }

}

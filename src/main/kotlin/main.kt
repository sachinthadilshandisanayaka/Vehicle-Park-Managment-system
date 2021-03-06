import dataServer.fileHandler.WriteFile
import input.GetVehicleType
import input.ServiceType
import operation.ServiceCheck
import operation.VehicleTypeCheck
import service.out.CalculateDuration
import ui.ServiceErrorPrint
import ui.UiServiceType
import ui.VehicleType


fun main(args : Array<String>) {
//    var readFileObject: MutableList<String>? = readFile()
//    println(readFileObject?.toString() + "\n" + readFileObject?.size)
    var uiServiceType =  UiServiceType().print()
    var inputServiceType = ServiceType().printServices()
    var seviceCheck = inputServiceType?.let { ServiceCheck().check(it) }

    if(seviceCheck == null) {
        var serviceErrorPrint = ServiceErrorPrint().print()
        return;
    } else if (seviceCheck == "park") {
        var vehicleType = VehicleType().print()
        var getVehicleType = GetVehicleType().getType()
        var vehicleDetail = getVehicleType?.let { VehicleTypeCheck().check(it) }
        if(vehicleDetail == null) {
            return;
        } else {
            var writeFile = WriteFile().writeFile(getVehicleType.toString(), vehicleDetail)
            if(writeFile) {
                println("done")
            }
        }

    } else if (seviceCheck == "out") {
        var outOperation = CalculateDuration().getVehicleData()
    }
}
package singlecycle
import chisel3._
import chisel3.util._
//import Store_Fun3._

// class memory extends Module {
//   val io = IO(new Bundle {
//    })}
//   val mem = Module(new Mem)
//   dontTouch(mem.io)
//   val memory = Mem(1024, Vec(4, SInt(8.W)))
//   when(mem.io.store) {
//     memory.write(mem.io.address, mem.io.wdata, mem.io.mask)
//   }
//   mem.io.rdata := memory(mem.io.address)

// }
// ///////////////////////
// object Load_Fun3 {

//   val ALU_LB = 0.U(4.W)
//   val ALU_LH = 1.U(4.W)
//   val ALU_LW = 2.U(4.W)
//   val ALU_LBU = 4.U(4.W)
//   val ALU_LHU = 5.U(4.W)
// }
// import Load_Fun3._
// class Load extends Module {
//   val io = IO(new Bundle {
//     val fun3 = Input(UInt(3.W))
//     val address = Input(UInt(2.W))
//     val wdata = Input(Vec(4, UInt(8.W)))
//     val rdata = Output(SInt(32.W))
//   })
//   io.rdata := 0.S
//   when(io.fun3 === ALU_LB) {
//     when(io.address === 0.U) {
//       io.rdata := Cat(Fill(24, (io.wdata(0))(7)), io.wdata(0)).asSInt
//     }
//     .elsewhen(io.address === 1.U) {
//       io.rdata := Cat(Fill(24, (io.wdata(1))(7)), io.wdata(1)).asSInt
//     }
//     .elsewhen(io.address === 2.U) {
//       io.rdata := Cat(Fill(24, (io.wdata(2))(7)), io.wdata(2)).asSInt
//     }
//     .elsewhen(io.address === 3.U) {
//       io.rdata := Cat(Fill(24, (io.wdata(3))(7)), io.wdata(3)).asSInt
//     }
//   }
//   .elsewhen(io.fun3 === ALU_LH) {
//     when(io.address === 0.U) {
//       val temp = Cat( io.wdata(1),io.wdata(0) )
//       io.rdata := Cat(Fill(16, temp(15)), temp  ).asSInt
//     }

//      .elsewhen(io.address === 1.U) {
//       val temp = Cat( io.wdata(2),io.wdata(1) )
//       io.rdata := Cat(Fill(16,temp(15)),temp).asSInt
//     }

//      .elsewhen(io.address === 2.U) {
//       val temp = Cat( io.wdata(3),io.wdata(2) )
//       io.rdata := Cat(Fill(16, temp(15)), temp).asSInt
//     }

//      .elsewhen(io.address === 3.U) {
//       val temp = Cat(  io.wdata(0),io.wdata(3) )
//       io.rdata := Cat(Fill(16, temp(15)), temp).asSInt
//     }
//   }
//   .elsewhen(io.fun3 === ALU_LW) {
//     io.rdata := Cat((io.wdata(3)),(io.wdata(2)),(io.wdata(1)),(io.wdata(0))).asSInt
//   }
//   .elsewhen(io.fun3 === ALU_LBU) {
//     when(io.address === 0.U) {
      
//       io.rdata := (Cat(Fill(24, (io.wdata(0))(7)), io.wdata(0)).asUInt).asSInt
//     }
//     .elsewhen(io.address === 1.U) {
//       io.rdata := (Cat(Fill(24, (io.wdata(1))(7)), io.wdata(1)).asUInt).asSInt
//     }
//     .elsewhen(io.address === 2.U) {
//       io.rdata := (Cat(Fill(24, (io.wdata(2))(7)), io.wdata(2)).asUInt).asSInt
//     }
//     .elsewhen(io.address === 3.U) {
//       io.rdata := (Cat(Fill(24, (io.wdata(3))(7)), io.wdata(3)).asUInt).asSInt
//     }
//   }
//   .elsewhen(io.fun3 === ALU_LHU) {
//     when(io.address === 0.U) {
//       val temp = Cat( io.wdata(1),io.wdata(0))
//       io.rdata := (Cat(Fill(16, temp(15)), temp).asUInt).asSInt
//     }

//      .elsewhen(io.address === 1.U) {
//       val temp = Cat( io.wdata(2),io.wdata(1))
//       io.rdata := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
//     }

//      .elsewhen(io.address === 2.U) {
//       val temp = Cat( io.wdata(3),io.wdata(2))
//       io.rdata := (Cat(Fill(16, temp(15)), temp).asUInt).asSInt
//     }

//      .elsewhen(io.address === 3.U) {
//       val temp = Cat(io.wdata(0),io.wdata(3))

//       io.rdata := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
//     }
//   }
// }
 


// ///////////////////////

// object Store_Fun3 {

//   val ALU_SB = 0.U(4.W)
//   val ALU_SH = 1.U(4.W)
//   val ALU_SW = 2.U(4.W)
// }
// import Store_Fun3._
// class Store extends Module {
//   val io = IO(new Bundle {
//     val address = Input(UInt(10.W))
//     val fun3 = Input(UInt(3.W))
//     val wdata = Input(UInt(32.W))
//     val mask =Output(Vec(4, UInt(8.W)))
//     val rdata = Output(Vec(4, UInt(32.W)))
//   })

//       io.mask(0) := 0.B
//       io.mask(1) := 0.B
//       io.mask(2) := 0.B
//       io.mask(3) := 0.B

//     io.rdata(0) := 0.U
//     io.rdata(1) := 0.U
//     io.rdata(2) := 0.U
//     io.rdata(3) := 0.U

//   when(io.fun3 === ALU_SB) {
//     when(io.address(1,0) === 0.U) {
//       io.rdata(0) := io.wdata(7,0)
//       io.rdata(1) := 0.B
//       io.rdata(2) := 0.B
//       io.rdata(3) := 0.B
      
//     }

//     when(io.address(1,0) === 1.U) {
//       io.rdata(0) := 0.B
//       io.rdata(1) := io.wdata(7,0)
//       io.rdata(2) := 0.B
//       io.rdata(3) := 0.B
//     }

//     when(io.address(1,0) === 2.U) {
//       io.rdata(0) := 0.B
//       io.rdata(1) := 0.B
//       io.rdata(2) := io.wdata(7,0)
//       io.rdata(3) := 0.B

//     }
//     when(io.address(1,0) === 3.U) {
//       io.rdata(0) := 0.B
//       io.rdata(1) := 0.B
//       io.rdata(2) := 0.B
//       io.rdata(3) := io.wdata(7,0)
//     }
//   }

//   when(io.fun3 === ALU_SH) {
//     when(io.address(1,0) === 0.U) {
//       io.rdata(0) := io.wdata(7,0)
//       io.rdata(1) := io.wdata(15,8)
//       io.rdata(2) := 0.B
//       io.rdata(3) := 0.B
//     }

//     when(io.address(1,0) === 1.U) {
//       io.rdata(0) := 0.B
//       io.rdata(1) := io.wdata(7,0)
//       io.rdata(2) := io.wdata(15,8)
//       io.rdata(3) := 0.B
//     }

//     when(io.address(1,0) === 2.U) {
//       io.rdata(0) := 0.B
//       io.rdata(1) := 0.B
//       io.rdata(2) := io.wdata(7,0)
//       io.rdata(3) := io.wdata(15,8)
//     }
   
//     when(io.address(1,0) === 3.U) {
//       io.rdata(0) := io.wdata(15,8)
//       io.rdata(1) := 0.B
//       io.rdata(2) := 0.B
//       io.rdata(3) := io.wdata(7,0)
//     }
  
//   }
//   when(io.fun3 === ALU_SW) {
//       io.rdata(0) := io.wdata(7,0)
//       io.rdata(1) := io.wdata(15,8)
//       io.rdata(2) := io.wdata(23,16)
//       io.rdata(3) := io.wdata(31,24)
//   }

  
// when(io.fun3 === ALU_SB) {
//     when(io.address(1,0) === 0.U) {
//       io.mask(0) := 1.B
//       io.mask(1) := 0.B
//       io.mask(2) := 0.B
//       io.mask(3) := 0.B
//     }

//     when(io.address(1,0) === 1.U) {
//       io.mask(0) := 0.B
//       io.mask(1) := 1.B
//       io.mask(2) := 0.B
//       io.mask(3) := 0.B
//     }

//     when(io.address(1,0) === 2.U) {
//       io.mask(0) := 0.B
//       io.mask(1) := 0.B
//       io.mask(2) :=1.B
//       io.mask(3) := 0.B

//     }
//     when(io.address(1,0) === 3.U) {
//       io.mask(0) := 0.B
//       io.mask(1) := 0.B
//       io.mask(2) := 0.B
//       io.mask(3) := 1.B
//     }
//   }

//   when(io.fun3 === ALU_SH) {
//     when(io.address(1,0) === 0.U) {
//       io.mask(0) :=1.B
//       io.mask(1) := 1.B
//       io.mask(2) := 0.B
//       io.mask(3) := 0.B
//     }

//     when(io.address(1,0) === 1.U) {
//       io.mask(0) := 0.B
//       io.mask(1) := 1.B
//       io.mask(2) := 1.B
//       io.mask(3) := 0.B
//     }

//     when(io.address(1,0) === 2.U) {
//       io.mask(0) := 0.B
//       io.mask(1) := 0.B
//       io.mask(2) :=1.B
//       io.mask(3) := 1.B
//     }
   
//     when(io.address(1,0) === 3.U) {
//       io.mask(0) := 1.B
//       io.mask(1) := 0.B
//       io.mask(2) := 0.B
//       io.mask(3) := 1.B
//     }
  
//   }
//   when(io.fun3 === ALU_SW) {
//       io.mask(0) :=1.B
//       io.mask(1) := 1.B
//       io.mask(2) := 1.B
//       io.mask(3) := 1.B
//   }

// }


class datamemory extends Module {
  val io = IO(new Bundle {
//     val func=Input(UInt(7.W))
    val in=Input(SInt(32.W))
     val address=Input(UInt(32.W))
     val store=Input(Bool())
     val out=Output(SInt(32.W))
     val load=Input(Bool())
  })
   val memory = Mem(1024, SInt(8.W))
  when(io.store) {
    memory.write(io.address, io.in)
  }
  io.out :=  memory(io.address)

//     dontTouch(dmem.io)
//     val store=Module(new Store)
//     dontTouch(store.io)
//     val load=Module(new Load)
//     dontTouch(load.io)


//     load.io.fun3:= io.func
//     load.io.wdata := dmem.mem.io.wdata
//     load.io.address:=(dmem.mem.io.address(1,0)).asUInt

//     //store
//     store.io.address:=Mux(io.ins(6,0)==="b0000011".U,(dmem.mem.io.wdata).asUInt,
//     Mux(io.ins(6,0)==="b0100011".U,
//     (Cat(io.ins(31,25),io.ins(11,7))+(io.d1).asUInt).asUInt,
//     0.U))
//     store.io.fun3:=io.func
//     store.io.wdata:=(io.d2).asUInt

     
}

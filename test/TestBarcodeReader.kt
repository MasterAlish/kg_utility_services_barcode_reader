/**
 * Created by master Alish on 8/7/18.
 *
 */
class TestBarcodeReader: junit.framework.TestCase(){
    val barcodeReader = UtilityBarcodeReader()

    fun testBarcodeDataIsForBishkekTeploseti(){
        val data = "10010565140000142008"
        val result = barcodeReader.detect(data)!!
        assertEquals("bishkekteploset", result.service)
        assertEquals("01056514", result.account)
        assertEquals(142.0, result.sum)
    }

    fun testBarcodeDataIsForCentObclujivaniyaDomofonov(){
        val data = "65101581006300"
        val result = barcodeReader.detect(data)!!
        assertEquals("centr_obslujivaniya_domofonov", result.service)
        assertEquals("101581", result.account)
        assertEquals(63.0, result.sum)
    }

    fun testBarcodeDataIsForBishkekGorLift(){
        val data = "9301300485000000009800"
        val result = barcodeReader.detect(data)!!
        assertEquals("bishkek_gor_lift", result.service)
        assertEquals("1300485", result.account)
        assertEquals(98.0, result.sum)
    }

    fun testBarcodeDataIsForTazalyk(){
        val data = "145004492000082508"
        val result = barcodeReader.detect(data)!!
        assertEquals("tazalyk", result.service)
        assertEquals("50044920", result.account)
        assertEquals(82.5, result.sum)
    }

    fun testBarcodeDataIsForSeverelectro(){
        val data = "35067361001006213500066500000008"
        val result = barcodeReader.detect(data)!!
        assertEquals("severelectro", result.service)
        assertEquals("350673610", result.account)
        assertEquals(628.0, result.sum)
    }

    fun testBarcodeDataIsForBishkekVodokanal(){
        val data = "02010565141008200067"
        val result = barcodeReader.detect(data)!!
        assertEquals("bishkek_vodokanal", result.service)
        assertEquals("01056514", result.account)
        assertEquals(82.0, result.sum)
    }

    fun testBarcodeDataIsForBishkekGas(){
        val data = "0301107202000100013100000000"
        val result = barcodeReader.detect(data)!!
        assertEquals("bishkekgas", result.service)
        assertEquals("011072020", result.account)
        assertEquals(131.0, result.sum)
    }

    fun testBarcodeDataIsForKomtransKom(){
        val data = "951511340500045009"
        val result = barcodeReader.detect(data)!!
        assertEquals("komtranskom", result.service)
        assertEquals("15113405", result.account)
        assertEquals(45.0, result.sum)
    }

    fun testBarcodeReaderReturnsNullForUnknownFormat(){
        val data = "123123123123123"
        val result = barcodeReader.detect(data)
        assertNull(result)
    }
}
/**
 * Created by master Alish on 8/7/18.
 *
 */
class TestBarcodeReader: junit.framework.TestCase(){
    val barcodeReader = UtilityBarcodeReader()

    fun testBarcodeDataIsForBishkekTeploseti(){
        val data = "10010565140000142008"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("bishkekteploset", results[0].service)
        assertEquals("0105651-4", results[0].account)
        assertEquals(142.0, results[0].sum)
    }

    fun testBarcodeDataIsForBishkekVodokanal2(){
        val data = "048639587810065002"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 2)
        assertEquals("bishkek_vodokanal", results[0].service)
        assertEquals("8639587-8", results[0].account)
        assertEquals(65.0, results[0].sum)
    }

    fun testBarcodeDataIsForCentObclujivaniyaDomofonov(){
        val data = "65101581006300"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("centr_obslujivaniya_domofonov", results[0].service)
        assertEquals("101581", results[0].account)
        assertEquals(63.0, results[0].sum)
    }

    fun testBarcodeDataIsForBishkekGorLift(){
        val data = "9301300485000000009800"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("bishkek_gor_lift", results[0].service)
        assertEquals("1300485", results[0].account)
        assertEquals(98.0, results[0].sum)
    }

    fun testBarcodeDataIsForTazalyk(){
        val data = "145004492000082508"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("tazalyk", results[0].service)
        assertEquals("5004492-0", results[0].account)
        assertEquals(82.5, results[0].sum)
    }

    fun test2BarcodeDataIsForTazalyk(){
        val data = "139003183000000004"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("tazalyk", results[0].service)
        assertEquals("9003183-0", results[0].account)
        assertEquals(0.0, results[0].sum)
    }

    fun testBarcodeDataIsForSeverelectro(){
        val data = "35067361001006213500066500000008"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 3)
        assertEquals("severelectro", results[0].service)
        assertEquals("350673610", results[0].account)
        assertEquals(628.0, results[0].sum)

        assertEquals("severelectro_talas", results[1].service)
        assertEquals("350673610", results[1].account)
        assertEquals(628.0, results[1].sum)

        assertEquals("severelectro_chui", results[2].service)
        assertEquals("350673610", results[2].account)
        assertEquals(628.0, results[2].sum)
    }

    fun testBarcodeDataIsForBishkekVodokanal(){
        val data = "02010565141008200067"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("bishkek_vodokanal", results[0].service)
        assertEquals("0105651-4", results[0].account)
        assertEquals(82.0, results[0].sum)
    }

    fun testBarcodeDataIsForBishkekGas(){
        val data = "0301107202000100013100000000"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 5)
        assertEquals("bishkekgas", results[0].service)
        assertEquals("011072020", results[0].account)
        assertEquals(131.0, results[0].sum)
    }

    fun testBarcodeDataIsForKomtransKom(){
        val data = "951511340500045009"
        val results = barcodeReader.detect(data)
        assertEquals(results.size, 1)
        assertEquals("komtranskom", results[0].service)
        assertEquals("1511340-5", results[0].account)
        assertEquals(45.0, results[0].sum)
    }

    fun testBarcodeReaderReturnsNullForUnknownFormat(){
        val data = "123123123123123"
        val result = barcodeReader.detect(data)
        assertTrue(result.isEmpty())
    }
}
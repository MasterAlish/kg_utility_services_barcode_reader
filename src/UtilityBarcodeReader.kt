/**
 * Created by master Alish on 8/7/18.
 *
 * В основном штрих-коды состоят из трех составляющих: Лицевой счет, Сумма Целая часть и Сумма дробная часть
 * и только в таком порядке.
 *
 * Но некоторые состоят из 5 составляющих: Лицевой счет, Сумма Целая часть и Сумма дробная часть,
 * Сумма Пени Целая часть и Сумма Пени дробная часть
 */
class UtilityBarcodeReader {
    val services = listOf(
            ServiceRegex("bishkekteploset", "^10(\\d{8})(\\d{7})(\\d{2})\\d$"),
            ServiceRegex("centr_obslujivaniya_domofonov", "^65(\\d{6})(\\d{4})(\\d{2})$"),
            ServiceRegex("bishkek_gor_lift", "^93\\d(\\d{7})\\d{5}(\\d{5})(\\d{2})$"),
            ServiceRegex("tazalyk", "^14(\\d{8})(\\d{5})(\\d{2})\\d$"),
            ServiceRegex("bishkek_vodokanal", "^02(\\d{8})\\d(\\d{4})(\\d{2})\\d{3}$"),
            ServiceRegex("bishkekgas", "^03(\\d{9})\\d{3}(\\d{6})(\\d{2})\\d{6}$"),
            ServiceRegex("komtranskom", "^95(\\d{8})(\\d{5})(\\d{2})\\d$"),
            ServiceRegex("severelectro", "^(\\d{9})\\d{2}(\\d{5})(\\d{2})(\\d{4})(\\d{2})\\d{8}$")
    )

    fun detect(code: String): BarcodeReadResult?{
        for ((service, regex) in services){
            val pattern = Regex(regex)
            if(pattern.matches(code)){
                val result = pattern.find(code)
                if(result != null) {
                    if (result.groupValues.size == 4) {
                        val account = formatAccount(service, result.groupValues[1])
                        var sum = result.groupValues[2].toDouble()
                        sum += result.groupValues[3].toDouble()/100.0
                        return BarcodeReadResult(service, account, sum)
                    }else if(result.groupValues.size == 6){
                        val account = formatAccount(service, result.groupValues[1])
                        var sum = result.groupValues[2].toDouble()
                        sum += result.groupValues[3].toDouble()/100.0
                        sum += result.groupValues[4].toDouble()
                        sum += result.groupValues[5].toDouble()/100.0
                        return BarcodeReadResult(service, account, sum)
                    }
                }
            }
        }
        return null
    }

    private fun formatAccount(service: String, raw_account: String): String {
        val len = raw_account.length
        return when(service){
            "komtranskom",
            "bishkekteploset",
            "bishkek_vodokanal",
            "tazalyk" -> raw_account.substring(0, len - 1) + "-" + raw_account.substring(len - 1)
            else -> raw_account
        }
    }
}
package learn.implicits

/**
 * 计算消费税，对于简单的场景，设定一个固定的浮点数就可以满足需求，但是有些场景需要知道当前事务发生的具体地点，以便增收地方税。而为了促销，某些辖区也可能会将年假最后几天设定为免税期。
 *
 * 我们可以使用隐式方法来解决这个问题。隐式对象本身不具有任何参数，除非该参数同样被标示为隐式参数
 * 
 * 
 */
// src/main/scala/progscala2/implicits/implicit-args.sc

// Never use Floats for money:
object SaleRateDemo extends App{

  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

  object SimpleStateSalesTax {
    implicit val rate: Float = 0.05F
  }

  case class ComplicatedSalesTaxData(
    baseRate: Float,
    isTaxHoliday: Boolean,
    storeId: Int)

  object ComplicatedSalesTax {
    private def extraTaxRateForStore(id: Int): Float = {
      // From id, determine location, then extra taxes...
      0.0F
    }

    implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float =
      if (cstd.isTaxHoliday) 0.0F
      else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
  }

  {
    import SimpleStateSalesTax.rate

    val amount = 100F
    println(s"Tax on $amount = ${calcTax(amount)}")//Tax on 100.0 = 5.0
  }

  {
	  implicit val myStore = ComplicatedSalesTaxData(0.06F, false, 1010)
    import ComplicatedSalesTax.rate

    val amount = 100F
    println(s"Tax on $amount = ${calcTax(amount)}")//Tax on 100.0 = 6.0
  }
}






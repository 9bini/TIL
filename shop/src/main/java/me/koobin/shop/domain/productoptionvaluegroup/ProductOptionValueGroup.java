package me.koobin.shop.domain.productoptionvaluegroup;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOption;
import me.koobin.shop.domain.productoptionvalue.ProductOptionValue;

/**
 * @author gutaegyun
 */
@Entity
@NoArgsConstructor
public class ProductOptionValueGroup {

  @Id @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_option_value_id")
  private ProductOptionValue productOptionValue;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_option_value_group_option_id")
  private ProductOptionValueGroupOption productOptionValueGroupOption;

  public ProductOptionValueGroup(ProductOptionValue productOptionValue,
      ProductOptionValueGroupOption productOptionValueGroupOption) {
    this.productOptionValue = productOptionValue;
    this.productOptionValueGroupOption = productOptionValueGroupOption;
  }
}

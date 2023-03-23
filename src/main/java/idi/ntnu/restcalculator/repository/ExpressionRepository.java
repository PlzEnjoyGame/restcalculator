package idi.ntnu.restcalculator.repository;

import idi.ntnu.restcalculator.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Vladimir Lenkov
 * @since 21/03/2023
 */
public interface ExpressionRepository extends JpaRepository<Expression, Integer> {
    List<Expression> findAllByUserid(int userid);
}

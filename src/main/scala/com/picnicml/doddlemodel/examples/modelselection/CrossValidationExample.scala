package com.picnicml.doddlemodel.examples.modelselection

import com.picnicml.doddlemodel.data.loadBreastCancerDataset
import com.picnicml.doddlemodel.linear.LogisticRegression
import com.picnicml.doddlemodel.metrics.accuracy
import com.picnicml.doddlemodel.modelselection.CrossValidation

object CrossValidationExample extends App {
  println("Cross-validated logistic regression model trained on the breast cancer dataset:")
  val (x, y) = loadBreastCancerDataset
  println(s"number of examples: ${x.rows}, number of features: ${x.cols}")

  // lambda is L2 regularization strength
  val model = LogisticRegression(lambda = 1.5)
  val cv = CrossValidation(metric = accuracy, folds = 10)

  val score = cv.score(model, x, y)
  println(f"cross-validation accuracy: $score%1.4f")
}

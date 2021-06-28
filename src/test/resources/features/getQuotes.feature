@quotes
Feature: This feature file contains the test cases related to fetching quotes with filters

  @page
  Scenario Outline: Fetching the quotes with the filter provided as "PAGE"
    Given User creates the getQuotes api request payload with filter as "page" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "lastItemIndex" and value is "<count>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
    | input   | output | count |
    |  1      |    1   |   20  |
    |  2      |    2   |   40  |
    |  h      |    1   |   20  |
    |  A34    |    1   |   20  |
    |  a$%56  |    1   |   20  |
    |  0      |    1   |   20  |
    |  -4     |    1   |   20  |
    |         |    1   |   20  |


  @author
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR"
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "results[0].author" and value is "<output>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
      |     input       |     output      |
      | Albert Einstein | Albert Einstein |
      |                 | Helmut Schmidt  |

  @author
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR" with invalid names
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "count" and value is "<output>"
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input      | output |
      | Albert     |   0    |
      | asdg       |   0    |
      | AShdg6786  |   0    |
      | 123 Albert |   0    |

  @author
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR" with invalid name
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 500
    Examples:
      | input      |
      | $%^$^%     |

  @tags
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS"
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the tags field in response has data as "<resp>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
      | input                    | output | resp                        |
      | famous-quotes,wisdom     |   1    | famous-quotes,wisdom        |
      |                          |   1    | famous-quotes,inspirational |

  @tags
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS"
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the tags field in response has data as either tags mentioned in "<input>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
      | input                    | output |
      | famous-quotes!wisdom     |   1    |

  @tags
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS" having invalid values
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results" as empty list
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input             | output |
      | famous-ques!wism  |   1    |
      | #$%^%!45645       |   1    |
      | 123!wis           |   1    |
      | 0000!             |   1    |

  @tags @author
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS" and "AUTHOR"
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>" and "author" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the tags field in response has data as either tags mentioned in "<input>"
    Then Verify that the response has field "results[0].author" and value is "<input1>"
    Examples:
      | input                 |     input1     | output  |
      | famous-quotes!wisdom  |   Confucius    |    1    |
      | famous-quotes,wisdom  |   Confucius    |    1    |

  @tags @author
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS" and "AUTHOR" with invalid values
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>" and "author" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results" as empty list
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input                 |   input1       | output  |
      | famous-quotes!wisdom  |   Confuci      |    1    |
      | famous-quote          |   Confucius    |    1    |
      | wid                   |   Confu        |    1    |
      | famous-quotes,wisdom  |   Confuc       |    1    |
      | famous-quots!wisdo    |   Confucius    |    1    |
      | famous-quotes!wisdo   |   Coucius      |    1    |

  @tags @page
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS" and "PAGE" with invalid values
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>" and "page" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results" as empty list
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input                 |   input1       | output  |
      | famous-quote          |   2            |    2    |
      | wid                   |   1            |    1    |
      | famous-quots!wisdo    |   1            |    1    |

  @tags @page
  Scenario Outline: Fetching the quotes with the filter provided as "TAGS" and "PAGE"
    Given User creates the getQuotes api request payload with filter as "tags" with value as "<input>" and "page" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the tags field in response has data as either tags mentioned in "<input>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
      | input                 |     input1     | output  |
      | famous-quotes!wisdom  |   2            |    2    |
      | famous-quotes,wisdom  |   1            |    1    |
      | famous-quotes!wisdom  |   1            |    1    |
      | famous-quotes,wisdom  |   2            |    2    |
      | famous-quotes!wisdo   |   2            |    2    |

  @author @page
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR" and "PAGE"
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>" and "page" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results[0].author" and value is "<input>"
    And Verify the json schema for the response as "getQuotesSuccess"
    Examples:
      | input      | input1 | output  |
      | Confucius  |   2    |    2    |
      | Confucius  |   1    |    1    |
      | Confucius  |   as   |    1    |
      | Confucius  |   #$   |    1    |


  @author @page
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR" and "PAGE"
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>" and "page" with value as "<input1>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results" as empty list
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input      | input1 | output  |
      | Confuciu   |   1    |    1    |
      | 1234hgfgh  |   1    |    1    |
      | Co#$5      |   2    |    2    |
      | Confucius  |   1500 |    1500  |

  @author @page @tags
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR", "PAGE" and "TAGS"
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>","page" with value as "<input1>" and "tags" with value as "<input2>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results[0].author" and value is "<input>"
    Then Verify that the tags field in response has data as either tags mentioned in "<input2>"
    Examples:
      | input           | input1 | input2               | output  |
      | Helmut Schmidt  |   1    | famous-quotes!wisdom |    1    |
      | Helmut Schmidt  |   as   | famous-quotes        |    1    |

  @author @page @tags
  Scenario Outline: Fetching the quotes with the filter provided as "AUTHOR", "PAGE" and "TAGS"
    Given User creates the getQuotes api request payload with filter as "author" with value as "<input>","page" with value as "<input1>" and "tags" with value as "<input2>"
    When User sends the request
    Then Verify that the status code is 200
    Then Verify that the response has field "page" and value is "<output>"
    Then Verify that the response has field "results" as empty list
    And Verify the json schema for the response as "getQuotesNoResults"
    Examples:
      | input           | input1 | input2               | output  |
      | Helmut Schmidt  |   1    | famous-quotes,wisdom |    1    |
      | Helmut Schmidt  |   #$   | wisdom               |    1    |
      | Helmut Schmi    |   #$   | wisd                 |    1    |
      | Helmut          |   2    | wisdom               |    2    |

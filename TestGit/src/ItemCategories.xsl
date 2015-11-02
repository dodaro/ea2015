<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" encoding="UTF-8" indent="yes" />
  <xsl:key name="groupsByCategory" match="ItemList/Item" use="CategoryID" />


  <xsl:template match="/">
    <categories>

      <xsl:for-each
        select="ItemList/Item[count(. | key('groupsByCategory', CategoryID)[1]) = 1]">
        <xsl:sort select="CategoryID" />
        <category>
          <xsl:attribute name="id">
              <xsl:value-of select="CategoryID" />
            </xsl:attribute>
          <name>
            <xsl:value-of select="CategoryName" />
          </name>
          <xsl:for-each select="key('groupsByCategory', CategoryID)">
            <xsl:sort select="ItemName" />
            <item>
              <name><xsl:value-of select="ItemName" /></name>
              <details><xsl:value-of select="ItemDetails" /></details>
            </item>
          </xsl:for-each>

        </category>

      </xsl:for-each>

    </categories>
  </xsl:template>

</xsl:stylesheet>

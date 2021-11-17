package org.orbisgis.demat

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.orbisdata.datamanager.jdbc.postgis.POSTGIS

import static org.orbisgis.demat.Plot.*

class PlotWithSQL {

    @Disabled
    @Test
    void testSimpleBarChart(TestInfo testInfo) {
        def  postgis_dbProperties = [databaseName: 'orbisgis_db',
                                     user        : 'orbisgis',
                                     password    : 'orbisgis',
                                     url         : 'jdbc:postgresql://localhost:5432/']

        POSTGIS postgis = POSTGIS.open(postgis_dbProperties)
        //Time graphic to display the number of vessels
        def query = """select to_date(date_year::text, 'YYYYMMDD') as date,
count as vessel
from
analyses.count_total_attested_presence_voyages_grouped_area where group_area=3
"""
        def rows =postgis.rows(query)
        Chart chart_count_vessel_group3 = Chart(Data(rows)).encode(X("date").temporal(), Y("vessel").quantitative()).mark_bar()
        //chart_count_vessel_group3.width(800).show()
    }
    }

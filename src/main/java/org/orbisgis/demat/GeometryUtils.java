package org.orbisgis.demat;

import org.h2gis.utilities.jts_utils.CoordinateUtils;
import org.locationtech.jts.geom.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GeometryUtils {

    static LinkedHashMap asMap(Geometry geom){
        return asMap(geom, 9);
    }

    static LinkedHashMap asMap(Geometry geom, int maxdecimaldigits){
        LinkedHashMap geometry_map = new LinkedHashMap();
        if (geom instanceof Point) {
            geometry_map.put("geometry", toPoint((Point) geom, maxdecimaldigits));
        } else if (geom instanceof LineString) {
            geometry_map.put("geometry", toGeojsonLineString((LineString) geom, maxdecimaldigits));
        } else if (geom instanceof Polygon) {
            geometry_map.put("geometry", toGeojsonPolygon((Polygon) geom,maxdecimaldigits));
        } else if (geom instanceof MultiPoint) {
            geometry_map.put("geometry", toGeojsonMultiPoint((MultiPoint) geom, maxdecimaldigits));
        } else if (geom instanceof MultiLineString) {
            geometry_map.put("geometry", toGeojsonMultiLineString((MultiLineString) geom, maxdecimaldigits));
        } else if (geom instanceof MultiPolygon) {
            geometry_map.put("geometry", toGeojsonMultiPolygon((MultiPolygon) geom,maxdecimaldigits));
        } else {
            geometry_map.put("geometry", toGeojsonGeometryCollection((GeometryCollection) geom, maxdecimaldigits));
        }
        return geometry_map;
    }

    public static LinkedHashMap toPoint(Point point, int maxdecimaldigits ) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "Point");
        Coordinate coord = point.getCoordinate();
        ArrayList coord_= new ArrayList();
        coord_.add(CoordinateUtils.round(coord.x, maxdecimaldigits));
        coord_.add(CoordinateUtils.round(coord.y, maxdecimaldigits));
        if (!Double.isNaN(coord.z)) {
            coord_.add(CoordinateUtils.round(coord.z, maxdecimaldigits));
        }
        geometry_values.put("coordinates", coord_);
        return geometry_values;
    }

    public static  LinkedHashMap  toGeojsonLineString(LineString lineString, int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "LineString");
        geometry_values.put("coordinates", toGeojsonCoordinates(lineString.getCoordinates(),maxdecimaldigits));
        return geometry_values;
    }

    public static LinkedHashMap toGeojsonPolygon(Polygon polygon,int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "Polygon");
        //Process exterior ring
        ArrayList allCoords =  new ArrayList<>();
        allCoords.add(toGeojsonCoordinates(polygon.getExteriorRing().getCoordinates(), maxdecimaldigits));
        //Process interior rings
        for (int i = 0; i < polygon.getNumInteriorRing(); i++) {
            allCoords.add(toGeojsonCoordinates(polygon.getInteriorRingN(i).getCoordinates(),maxdecimaldigits));
        }
        geometry_values.put("coordinates", allCoords);
        return geometry_values;
    }

    public static LinkedHashMap toGeojsonMultiPoint(MultiPoint multiPoint,int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "MultiPoint");
        geometry_values.put("coordinates", toGeojsonCoordinates(multiPoint.getCoordinates(), maxdecimaldigits));
        return geometry_values;
    }

    public static LinkedHashMap toGeojsonMultiLineString(MultiLineString multiLineString,int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "MultiLineString");

        int size = multiLineString.getNumGeometries();
        ArrayList allCoords =  new ArrayList<>();
        for (int i = 0; i < size; i++) {
            allCoords.add(toGeojsonCoordinates(multiLineString.getGeometryN(i).getCoordinates(),maxdecimaldigits));

        }
        geometry_values.put("coordinates",allCoords);
        return geometry_values;
    }

    public static LinkedHashMap toGeojsonMultiPolygon(MultiPolygon multiPolygon, int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "MultiPolygon");
        int size = multiPolygon.getNumGeometries();
        ArrayList allCoords =  new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList pCoords =  new ArrayList<>();
            Polygon p = (Polygon) multiPolygon.getGeometryN(i);
            //Process exterior ring
            pCoords.add(toGeojsonCoordinates(p.getExteriorRing().getCoordinates(),maxdecimaldigits));
            //Process interior rings
            int size_p = p.getNumInteriorRing();
            for (int j = 0; j < size_p; j++) {
                pCoords.add(toGeojsonCoordinates(p.getInteriorRingN(j).getCoordinates(), maxdecimaldigits));
            }
            allCoords.add(pCoords);
        }
        geometry_values.put("coordinates",allCoords);
        return geometry_values;
    }


    public static LinkedHashMap toGeojsonGeometryCollection(GeometryCollection geometryCollection,int maxdecimaldigits) {
        LinkedHashMap geometry_values= new LinkedHashMap();
        geometry_values.put("type", "GeometryCollection");
        ArrayList geometries= new ArrayList();
        int size = geometryCollection.getNumGeometries();
        for (int i = 0; i < size; i++) {
            Geometry geom = geometryCollection.getGeometryN(i);
            if (geom instanceof Point) {
                geometries.add(toPoint((Point) geom, maxdecimaldigits));
            } else if (geom instanceof LineString) {
                geometries.add(toGeojsonLineString((LineString) geom, maxdecimaldigits ));
            } else if (geom instanceof Polygon) {
                geometries.add(toGeojsonPolygon((Polygon) geom,maxdecimaldigits));
            }
        }
        geometry_values.put("geometries",geometries );
        return geometry_values;

    }


    public static ArrayList toGeojsonCoordinates(Coordinate[] coords, int maxdecimaldigits) {
        ArrayList coords_= new ArrayList();
        for (int i = 0; i < coords.length; i++) {
            coords_.add(toGeojsonCoordinate(coords[i],maxdecimaldigits));
        }
        return coords_;
    }

    public static ArrayList toGeojsonCoordinate(Coordinate coord, int maxdecimaldigits) {
        ArrayList coord_= new ArrayList();
        coord_.add(CoordinateUtils.round(coord.x, maxdecimaldigits));
        coord_.add(CoordinateUtils.round(coord.y, maxdecimaldigits));
        if (!Double.isNaN(coord.z)) {
            coord_.add(CoordinateUtils.round(coord.z, maxdecimaldigits));
        }
        return coord_;
    }

}

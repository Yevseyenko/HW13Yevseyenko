package com.epam.transformer;

import com.epam.annotations.Field;
import com.epam.annotations.Operations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTransformer {

    public static <T> List<T> ResultSetToListOfObjects(ResultSet rs, Class<T> cls) throws SQLException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<T> result = new ArrayList<T>();
        Map<String, Method> methodHolder = new HashMap<>();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(Field.class))
                continue;
            Field f = method.getAnnotation(Field.class);
            if (f.type() != Operations.SET)
                continue;
            methodHolder.put(f.fieldName(), method);
        }
        while (rs.next()) {
            Object instance = cls.newInstance();
            int colNum = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= colNum; i++) {
                Method method = methodHolder.getOrDefault(rs.getMetaData().getColumnName(i), null);
                if (method == null)
                    continue;
                Parameter[] parameters = method.getParameters();
                if (parameters.length != 1) continue;
                if (parameters[0].getType() == int.class | parameters[0].getType() == Integer.class)
                    method.invoke(instance, Integer.parseInt(rs.getObject(i).toString()));
                else if (parameters[0].getType() == String.class)
                    method.invoke(instance, rs.getObject(i).toString());
            }
            result.add((T) instance);
        }
        return result;
    }
}

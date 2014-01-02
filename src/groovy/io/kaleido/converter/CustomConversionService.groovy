package io.kaleido.converter

class CustomConversionService {

    List converters = []

    def convert(Object obj) {

        def convertedObj
        if (!obj)
            throw new IllegalArgumentException("'null' is not a convertable object.")

        if (converters) {
            for (converter in converters) {
                if (converter.canConvert(obj)) {
                    convertedObj = converter.convert(obj)
                    break;
                }
            }
        }

        return convertedObj
    }

    def convert(List objs) {

        if (!objs || objs.size() == 0)
            throw new IllegalArgumentException("'null' is not a convertable object.")

        def convertedObjs = []

        for (obj in objs) {
            convertedObjs.add(convert(obj))
        }

        return convertedObjs
    }

    private List convertObjects(objects, converter) {
        def l = []
        for (obj in objects) {
            l.add(converter.convert(obj))
        }
        return l
    }

}
